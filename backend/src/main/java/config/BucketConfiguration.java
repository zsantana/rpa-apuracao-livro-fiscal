package config;

import io.smallrye.config.ConfigMapping;

@ConfigMapping(prefix = "bucket")
public interface BucketConfiguration {

    String bucketName();

}